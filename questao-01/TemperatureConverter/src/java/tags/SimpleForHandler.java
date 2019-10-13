package tags;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Carlos
 */
public class SimpleForHandler extends SimpleTagSupport {

    private String var;
    private int start;
    private int end;
    private int step;

    public SimpleForHandler() {
        this.step = 1;
    }

    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();

        try {
            JspFragment f = getJspBody();
            if (f != null) {
                for (int i = start; i <= end; i += step) {
                    getJspContext().setAttribute(var, i);
                    f.invoke(out);
                }
            }
        } catch (java.io.IOException ex) {
            throw new JspException("Error in SimpleForTags tag", ex);
        }
    }

    public void setVar(String var) {
        this.var = var;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setStep(int step) {
        this.step = step;
    }

}
