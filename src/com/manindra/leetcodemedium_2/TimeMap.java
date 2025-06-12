package com.manindra.leetcodemedium_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TimeMap { //solution 981

    private Map<String, ArrayList<TimeStampedValue>> entriesByKey;

    public TimeMap() {
        entriesByKey = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        entriesByKey.putIfAbsent(key, new ArrayList<>());
        entriesByKey.get(key).add(new TimeStampedValue(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!entriesByKey.containsKey(key)) return "";

        ArrayList<TimeStampedValue> values = entriesByKey.get(key);
        Optional<TimeStampedValue> result = binarySearch(values, timestamp);
        return result.map(v -> v.value).orElse("");
    }

    private Optional<TimeStampedValue> binarySearch(ArrayList<TimeStampedValue> list, int target) {
        int left = 0, right = list.size() - 1;
        int matchIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).timestamp <= target) {
                matchIndex = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return matchIndex == -1 ? Optional.empty() : Optional.of(list.get(matchIndex));
    }

    // Helper class for storing value with timestamp
    static class TimeStampedValue {
        int timestamp;
        String value;

        TimeStampedValue(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }


    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();

        timeMap.set("foo", "bar", 1);
        System.out.println(timeMap.get("foo", 1));  // Output: "bar"
        System.out.println(timeMap.get("foo", 3));  // Output: "bar"

        timeMap.set("foo", "bar2", 4);
        System.out.println(timeMap.get("foo", 4));  // Output: "bar2"
        System.out.println(timeMap.get("foo", 5));  // Output: "bar2"

        System.out.println(timeMap.get("foo", 0));  // Output: ""
        System.out.println(timeMap.get("baz", 1));  // Output: ""
    }
}

