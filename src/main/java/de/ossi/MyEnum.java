package de.ossi;

public class MyEnum implements IEnum {
    private final int ordinal;

    public static final MyEnum ENUM_0 = new MyEnum(0);
    public static final MyEnum ENUM_1 = new MyEnum(1);
    public static final MyEnum ENUM_2 = new MyEnum(2);

    public static final MyEnum[] VALUES = {ENUM_0, ENUM_1, ENUM_2};

    public MyEnum(int ordinal) {this.ordinal = ordinal;}

    public int ordinal() {
        return ordinal;
    }
}
