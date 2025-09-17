package question7;

import java.util.ArrayList;
import java.util.List;

public class Order implements Cloneable {
    public List<OrderLine> lines = new ArrayList<>();

    public void addLine(OrderLine line) {
        lines.add(line);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Order(Order other) {
        this.lines = new ArrayList<>();
        for (OrderLine line : other.lines) {
            this.lines.add(new OrderLine(line.product));
        }
    }

    public Order() {
    }
}
