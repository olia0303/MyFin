package utils;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Log4j2
public class DateUtils {
    public static String convertDate(String date, String inPattern, String outPattern) {
        if (StringUtils.isNotBlank(date)) {
            Date inputDate = null;
            SimpleDateFormat inputPattern = new SimpleDateFormat(inPattern);
            SimpleDateFormat outputPattern = new SimpleDateFormat(outPattern);
            try {
                inputDate = inputPattern.parse(date);
            } catch (ParseException e) {
                log.error(e.getMessage());
            }
            return outputPattern.format(inputDate);
        } else {
            return "";
        }
    }

        /**
         * @param countDays  - number of days to be added or discarded, e.g. -5 (5 days ago) or 365 (one year in the future)
         * @param outPattern - output format of the date
         * @return
         */

        public static String getDate(long countDays, String outPattern) {
            return convertDate(LocalDate.now().plusDays(countDays).toString(), "yyyy-MM-dd", outPattern);
        }
    }
