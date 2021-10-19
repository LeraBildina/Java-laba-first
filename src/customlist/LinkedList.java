package customlist;
/**
 *
 * @author ilya-
 * @param <TypeOfData> Universal Type of data
 */

public class LinkedList<TypeOfData> {
    private int size;
    private Node<TypeOfData> head;
    /**
     *  List is creating object(empty)
     */
    public LinkedList() {
        size = 0;
        head = null;
    }
    /**
     *  list checks for emptiness
     */
    public boolean isEmpty() {
        return head == null;
    }
    /**
     * Returns the size
     */
    public int getSize() {
        return size;
    } /**
     * Adding an object to the top of the list
     */
    public void pushBack(TypeOfData data){
        if(isEmpty()){
            head = new Node<TypeOfData>(data);
        } else {
            Node<TypeOfData> temp = head;

            while( temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node<TypeOfData>(data);
        }
        size++;
    }
    /**
     * Adding an object to the end of the list
     */
    public void pushFront(TypeOfData data){
        if(isEmpty()){
            head = new Node<TypeOfData>(data);
        } else {
            Node<TypeOfData> tmp = new Node<TypeOfData>(data);
            tmp.next = head;
            head = tmp;
        }
        size++;
    }
    /**
     *  Inserting an object into a list
     */

    public void insertAt(int index, TypeOfData data) throws Exception {
        if(index > size) {
            throw new Exception("Выход за границы списка");
        }
        if(index == size){
            pushBack(data);
        } else if(index == 0){
            pushFront(data);
        } else {
            int step = 0;
            Node<TypeOfData> temp = head;

            while(step != index-1) {
                temp = temp.next;
                step++;
            }
            Node<TypeOfData> reference = temp.next;
            temp.next = new Node<TypeOfData>(data);
            temp.next.next = reference;
            size++;
        }
    }
    /**
     *  Removing an object from the end of the list
     */
    public void popBack() throws Exception{
        if(isEmpty()){
            throw new Exception("Некорректое удаление, список пуст");
        }
        if(size == 1){
            head = null;
        } else {
            Node<TypeOfData> temp = head;

            while(temp.next.next != null){
                temp = temp.next;
            }
            temp.next = null;
        }
        size--;
    }
    /**
     *  Removing an object from the top of the list
     */
    public void popFront() throws Exception {
        if(isEmpty()){
            throw new Exception("Некорректое удаление, список пуст");
        }
        head = head.next;
        size--;
    }
    /**
     *  Deleting a list object
     */
    public void eraseAt(int index) throws Exception {
        if(index >= size) {
            throw new Exception("Выход за границы списка");
        }
        if(index == 0){
            popFront();
        } else if( index == size-1){
            popBack();
        } else {
            Node<TypeOfData> temp = head;

            int step = 0;
            while( step != index-1){
                temp = temp.next;
                step++;
            }
            temp.next = temp.next.next;
            size--;
        }
    }
    /**
     *  Retrieving a list object
     */

    public TypeOfData getAt(int index) throws Exception {
        if(index >= size) {
            throw new Exception("Выход за границы списка");
        }
        Node<TypeOfData> temp = head;

        int step = 0;
        while(step != index){
            temp = temp.next;
            step++;
        }

        return temp.data;
    }
    /**
     *  Overloading the equality operator
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        LinkedList<?> other = (LinkedList<?>) obj;
        if(this.size != other.size) {
            return false;
        }
        Node<?> tempMine = head;
        Node<?> tempOther = other.head;
        while(head != null){
            if(!tempMine.equals(tempOther)){
                return false;
            }
            tempMine = tempMine.next;
            tempOther = tempOther.next;
        }
        return true;
    }
    /**
     *  Converting a numeric type to a string type
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("");

        Node<?> temp = head;
        while(temp != null){
            str.append(temp.data.toString()).append("; ");
            temp = temp.next;
        }
        return "LinkedList{\n  size: " + size +"\n  list: " + str + "\n}";
    }
}
