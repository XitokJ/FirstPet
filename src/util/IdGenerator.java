package util;

public class IdGenerator {
    private static int idGen = 1;
    private static int idGenTicket = 1;

    public static int nextId()
    {
       return idGen++;
    }
    public static int nextIdForTicket()
    {
        return idGenTicket*2;
    }


}
