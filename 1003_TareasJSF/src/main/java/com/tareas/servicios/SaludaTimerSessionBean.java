
package com.tareas.servicios;

import java.util.Date;
import javax.ejb.Schedule;
import javax.ejb.Stateless;


@Stateless
public class SaludaTimerSessionBean {

   // @Schedule(dayOfWeek = "Mon-Fri", month = "*", hour = "9-17", dayOfMonth = "*", year = "*", minute = "*", second = "0", persistent = false)
  //  @Schedule(minute="*/1", hour="*")
    public void myTimer() {
        System.out.println("..... Timer SALUDO " + new Date());
    }


}
