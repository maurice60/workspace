package euler;

public class Euler {
    public pythagoreanTriple findTriple(int p, int q, int k) {
        return new pythagoreanTriple(k * (p * p - q * q), (2 * k * p * q), k * (p * p + q * q));
    }
}
