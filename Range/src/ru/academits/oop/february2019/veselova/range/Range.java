package ru.academits.oop.february2019.veselova.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public Range(Range other) {
        this(other.getFrom(), other.getTo());
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double value) {
        return (from <= value && value <= to);
    }

    public Range getIntersection(Range other) {
        if (isIntersected(other)) {
            return new Range(Math.max(from, other.from), Math.min(to, other.to));
        }

        return null;
    }

    public Range[] getUnion(Range other) {
        if (isIntersected(other)) {
            return new Range[]{new Range(Math.min(from, other.from), Math.max(to, other.to))};
        }

        return new Range[]{new Range(this), new Range(other)};
    }

    public Range[] getComplement(Range other) {
        if (isIntersected(other)) {
            if (from < other.from) {
                if (to > other.to) {
                    return new Range[]{new Range(from, other.from), new Range(other.to, to)};
                } else {
                    return new Range[]{new Range(from, other.from)};
                }
            } else {
                if (to > other.to) {
                    return new Range[]{new Range(other.to, to)};
                } else {
                    return new Range[]{};
                }
            }
        }

        return new Range[]{new Range(this)};
    }

    public boolean isIntersected(Range other) {
        return from < other.to && to > other.from;
    }

    @Override
    public String toString() {
        return "(" + from + ", " + to + ")";
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public void setTo(double to) {
        this.to = to;
    }
}