package tags;

import java.text.DecimalFormat;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Carlos
 */
public class TableFutureValueHandler extends SimpleTagSupport {

    private double investmentAmount;
    private double interestRate;
    private int numberMonths;
    private double contributions;

    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        DecimalFormat df = new DecimalFormat("R$ #.##");
        double contributionsSum = 0;
        double interestRateSum = 0;

        try {
            out.write("<table class=\"table text-white\">");
            out.write("<tr>");
            out.write("<th>Tempo do Investimento (Meses)</th>");
            out.write("<th>Montante</th>");
            out.write("<th>Juros</th>");
            out.write("<th>Aporte</th>");
            out.write("</tr>");

            for (int i = 1; i <= numberMonths; i++) {
                out.write("<tr>");
                out.write("<td>" + i + "° mês</td>");
                out.write("<td>" + df.format(investmentAmount) + "</td>");
                out.write("<td>" + df.format(investmentAmount * interestRate) + "</td>");
                out.write("<td>" + df.format(contributions) + "</td>");
                out.write("</tr>");

                interestRateSum = interestRateSum + (investmentAmount * interestRate);
                contributionsSum = contributionsSum + contributions;
                investmentAmount = investmentAmount + (investmentAmount * interestRate) + contributions;
            }

            out.write("<tr>");
            out.write("<th>Total</th>");
            out.write("<th>" + df.format(investmentAmount) + "</th>");
            out.write("<th>" + df.format(interestRateSum) + "</th>");
            out.write("<th>" + df.format(contributionsSum) + "</th>");
            out.write("</tr>");

            out.write("</table>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in TableFutureValueHandler tag", ex);
        }
    }

    public void setInvestmentAmount(double investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void setContributions(double contributions) {
        this.contributions = contributions;
    }

    public void setNumberMonths(int numberMonths) {
        this.numberMonths = numberMonths;
    }

}
