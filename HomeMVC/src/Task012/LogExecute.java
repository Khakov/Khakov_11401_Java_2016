package Task012;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Rus on 22.03.2016.
 */
public class LogExecute implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        if (methodInvocation.getMethod().getName().equals("execute")) {
            String sql = (String) methodInvocation.getArguments()[0];
            Pattern pattern = Pattern.compile("((.*)([;$])(.*))|(.*[=-])");
            Pattern pattern2 = Pattern.compile("((delete)|(alter)|(create)|(select)|(update)|(insert into table)(\\.+))");
            Matcher matcher = pattern.matcher(sql);
            Matcher matcher2 = pattern2.matcher(sql.toLowerCase());
            if(matcher.find()| !matcher2.find()){
                System.out.println("Warring!!!SQL injection!!!");
            }
        }
        return false;
    }
}
