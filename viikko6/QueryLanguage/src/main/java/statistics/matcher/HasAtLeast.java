
package statistics.matcher;

import java.lang.reflect.Method;

import statistics.Player;

public class HasAtLeast implements Matcher {

    private int value;
    private String fieldName;

    public HasAtLeast(int value, String category) {
        this.value = value;
        fieldName = "get" + Character.toUpperCase(category.charAt(0)) + category.substring(1, category.length());
    }

    @Override
    public boolean matches(Player player) {
        try {
            Method method = player.getClass().getMethod(fieldName);
            int playersValue = (Integer) method.invoke(player);
            return playersValue >= value;

        } catch (Exception ex) {
            System.out.println(ex);
            throw new IllegalStateException("Player does not have field " + fieldName.substring(3, fieldName.length()).toLowerCase());
        }

    }

}
