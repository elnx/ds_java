public class Term {
    double coef;
    int exp;
    Term next;
    public Term(double coef, int exp) {
        this.coef = coef;
        this.exp = exp;
    }
    public double getCoefficient() {
        return this.coef;
    }
    public void setCoefficient(double coef) {
        this.coef = coef;
    }
    public int getExponent() {
        return this.exp;
    }
    public void setExponent(int exp) {
        this.exp = exp;
    }
    public Term getNext() {
        return next;
    }
    public void setNext(Term next) {
        this.next = next;
    }

}

