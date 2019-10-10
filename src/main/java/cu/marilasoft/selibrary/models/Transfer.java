package cu.marilasoft.selibrary.models;

import cu.marilasoft.selibrary.Utils;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Transfer {

    private String _date;
    private String _import;
    private String _destinyAccount;

    public Transfer(String _date, String _import, String destinyAccount) {
        this._date = _date;
        this._import = _import;
        this._destinyAccount = destinyAccount;
    }

    public Calendar date() {
        String date, time;
        int day, month, year, hours, minutes, seconds;
        // Separa la fecha de la hora
        String[] date_time = Utils.splitString(_date, " ");
        date = date_time[0];
        time = date_time[1];

        // Separa el dia, mes y annio
        String[] day_month_year = Utils.splitString(date, "/");
        day = Integer.parseInt(day_month_year[0]);
        month = Integer.parseInt(day_month_year[1]) - 1;
        year = Integer.parseInt(day_month_year[2]);

        // Separa horas, minutos y segundos
        String[] hours_minutes_seconds = Utils.splitString(time, ":");
        hours = Integer.parseInt(hours_minutes_seconds[0]);
        minutes = Integer.parseInt(hours_minutes_seconds[1]);
        seconds = Integer.parseInt(hours_minutes_seconds[2]);
        Calendar date_ = new GregorianCalendar();
        date_.set(year, month, day, hours, minutes, seconds);

        return date_;
    }

    public float import_() {
        return Float.parseFloat(_import.replace("$", "").replace(",", "."));
    }

    public String destinyAccount() {
        return _destinyAccount;
    }
}