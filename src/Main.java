import java.util.*;

class InMemoryDatabase {
    private Map<String, Map<String, Integer>> database = new HashMap<>();
    private Map<String, Queue<String>> lockQueue = new HashMap<>();
    private Map<String, String> recordLocks = new HashMap<>();

    public String executeQuery(List<String> query) {
        String operation = query.get(0);
        switch (operation) {
            case "SET_OR_INC":
                return setOrInc(query.get(1), query.get(2), Integer.parseInt(query.get(3)), null);
            case "UNLOCK":
                return unlock(query.get(1));
            case "LOCK":
                return lock(query.get(1), query.get(2));
            case "SET_OR_INC_BY_CALLER":
                return setOrInc(query.get(1), query.get(2), Integer.parseInt(query.get(3)), query.get(4));
            case "DELETE_BY_CALLER":
                return delete(query.get(1), query.get(2), query.get(3));
            case "GET":
                return get(query.get(1), query.get(2));
            default:
                return "Invalid operation";
        }
    }

    private String setOrInc(String key, String field, int value, String callerId) {
        if (!database.containsKey(key) || !recordIsLockedByUser(key, callerId)) {
            return "";
        }

        Map<String, Integer> record = database.get(key);
        int existingValue = record.getOrDefault(field, 0);
        record.put(field, existingValue + value);
        return String.valueOf(existingValue + value);
    }

    private String unlock(String key) {
        if (!recordLocks.containsKey(key)) {
            return "";
        }

        String callerId = recordLocks.remove(key);
        Queue<String> queue = lockQueue.getOrDefault(key, new LinkedList<>());
        if (!queue.isEmpty()) {
            String nextCaller = queue.poll();
            recordLocks.put(key, nextCaller);
            return "released";
        }

        return "released";
    }

    private String lock(String callerId, String key) {
        if (!database.containsKey(key)) {
            return "invalid_request";
        }

        if (recordLocks.containsKey(key) && !recordLocks.get(key).equals(callerId)) {
            lockQueue.computeIfAbsent(key, k -> new LinkedList<>()).add(callerId);
            return "wait";
        }

        recordLocks.put(key, callerId);
        return "acquired";
    }

    private String delete(String key, String field, String callerId) {
        if (!database.containsKey(key) || !recordIsLockedByUser(key, callerId)) {
            return "false";
        }

        Map<String, Integer> record = database.get(key);
        record.remove(field);
        if (record.isEmpty()) {
            database.remove(key);
            removeLocksAndQueue(key);
        }

        return "true";
    }

    private String get(String key, String field) {
        if (!database.containsKey(key)) {
            return "";
        }

        Map<String, Integer> record = database.get(key);
        return record.getOrDefault(field, 0).toString();
    }

    private boolean recordIsLockedByUser(String key, String callerId) {
        return recordLocks.containsKey(key) && recordLocks.get(key).equals(callerId);
    }

    private void removeLocksAndQueue(String key) {
        recordLocks.remove(key);
        lockQueue.remove(key);
    }
}

public class Main {
    public static void main(String[] args) {
        InMemoryDatabase inMemoryDatabase = new InMemoryDatabase();
        List<List<String>> queries = Arrays.asList(
                Arrays.asList("SET_OR_INC", "A", "B", "4"),
                Arrays.asList("UNLOCK", "A"),
                Arrays.asList("LOCK", "user1", "A"),
                Arrays.asList("LOCK", "user2", "A"),
                Arrays.asList("LOCK", "user3", "B"),
                Arrays.asList("UNLOCK", "B"),
                Arrays.asList("SET_OR_INC", "A", "C", "5"),
                Arrays.asList("DELETE", "A", "B"),
                Arrays.asList("SET_OR_INC_BY_CALLER", "A", "B", "3", "user2"),
                Arrays.asList("GET", "A", "B"),
                Arrays.asList("DELETE_BY_CALLER", "A", "B", "user3"),
                Arrays.asList("SET_OR_INC_BY_CALLER", "A", "B", "5", "user1"),
                Arrays.asList("UNLOCK", "A"),
                Arrays.asList("SET_OR_INC_BY_CALLER", "A", "B", "2", "user1"),
                Arrays.asList("SET_OR_INC_BY_CALLER", "A", "B", "1", "user2"),
                Arrays.asList("LOCK", "user3", "A"),
                Arrays.asList("DELETE_BY_CALLER", "A", "B", "user2"),
                Arrays.asList("UNLOCK", "A")
        );

        List<String> output = new ArrayList<>();
        for (List<String> query : queries) {
            String result = inMemoryDatabase.executeQuery(query);
            output.add(result);
        }

        System.out.println(output);
    }
}
