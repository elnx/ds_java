import java.util.Formatter;
import java.lang.Math;
public class Polynomial {
    Term head;
    // create a polynomial
    public Polynomial(Term firstTerm) {
        this.head = new Term(0, 0);
        head.next = firstTerm;
    }
    // get the first term
    public Term getFirst() {
        return this.head.next;
    }
    // set the first term
    public void setFirst(Term first) {
        this.head.next = first;
    }
    // add a single term to the polynomial
    public void addTerm(Term term) {
        if (term == null)
            return;
        Term i = this.head;
        while (i.next != null && i.next.exp > term.exp) {
            i = i.next;
        }
        if (i.next != null && i.next.exp == term.exp)
            i.next.coef += term.coef;
        else {
            term.next = i.next;
            i.next = term;
        }
    }
    // add another polynomial, return the sum
    public Polynomial add(Polynomial another) {
        int size = Math.max(getFirst().exp, another.getFirst().exp) + 1;
        double a[] = new double[size];
        Term i;
        for (i = getFirst(); i != null; i = i.next)
            a[i.exp] += i.coef;
        for (i = another.getFirst(); i != null; i = i.next)
            a[i.exp] += i.coef;
        Polynomial ret = new Polynomial(null);
        for (int k = size-1; k >= 0; --k) {
            if (a[k] != 0)
                ret.addTerm(new Term(a[k], k));
        }
        return ret;
    }
    // convert to string representation
    // example: 4.0x^3+3.2x^2-2.1x^1+1.0x^0
    // example: -12.0x^9-1.0x^7+3.0x^5+10.0x^2+5.0x^0
    public String toString() {
        Formatter fmt = new Formatter();
        for (Term t = getFirst(); t != null; t = t.next) {
            fmt.format(
                "%c%.1fx^%d", 
                (t != getFirst() && t.coef > 0) ? '+': '\0',
                t.coef,
                t.exp
            );
        }
        return fmt.toString();
    }
    // write your own code to test your implementation
    public static void main(String[] args) {
        Term a = new Term(4, 3);
        Term b = new Term(4, 3);
        Term c = new Term(3, 2);
        Term d = new Term(-3, 5);
        Term e = new Term(1, 7);
        Polynomial p = new Polynomial(a);
        p.addTerm(b);
        p.addTerm(c);
        p.addTerm(d);
        p.addTerm(e);
        System.out.println(p);
        Polynomial q = new Polynomial(new Term(1, 1));
        q.addTerm(new Term(-1, 7));
        Polynomial r = p.add(q);
        System.out.println(r);
    }
}
