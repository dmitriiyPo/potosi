package threads.ex11;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Formatter implements Runnable{
    private Date date;

    public Formatter(Date date) {
        this.date = date;
    }

    public void format(Date data) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = sdf.format(data);
        System.out.println(str);
    }

    @Override
    public void run() {
        try{
            format(new Date());
        }catch (ParseException e){
            throw new RuntimeException(e);
        }
    }
}
