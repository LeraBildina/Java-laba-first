package customlist;

public class Node <TypeOfData> {
    TypeOfData data;
    Node<TypeOfData> next;

    public Node(TypeOfData _data){
        data = _data;
        next = null;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Node<?> other = (Node<?>) obj;
        if(!this.data.equals(other.data) || !this.next.equals(other.next)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Node{\ndata: " + data.toString() +"\n next: " + next.toString() + "}";
    }
}
