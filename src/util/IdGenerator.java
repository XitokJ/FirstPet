package util;

public class IdGenerator {
    private static int idGen = 1;

    public static int nextId()
    {
       return idGen++;
    }


}
