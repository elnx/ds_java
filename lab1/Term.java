public class Term {
    double coef;
    int exp;
    Term next;
    public Term(double coef, int exp) {
        this.coef = coef;
        this.exp = exp;
        this.next = null;
    }
    public double getCoefficient() {
        return this.coef;
    }
    public void setCoefficient(double coef) {
        // never handle coef 0
        if (coef != 0)
            this.coef = coef;
    }
    public int getExponent() {
        return this.exp;
    }
    public void setExponent(int exp) {
        this.exp = exp;
    }
    public Term getNext() {
        return this.next;
    }
    public void setNext(Term next) {
        this.next = next;
    }
}

