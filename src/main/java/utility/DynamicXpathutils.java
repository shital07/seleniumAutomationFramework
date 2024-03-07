package utility;

public final class DynamicXpathutils {

    private DynamicXpathutils() {

    }

    public static String getXpath(String path, String value) {
        return String.format(path, value);
    }
}
