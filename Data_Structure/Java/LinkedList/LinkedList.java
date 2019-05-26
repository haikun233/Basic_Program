
class LinkedList
{
	static class Node
	{
		int data;
		Node next;
		Node(int d)
		{
			data = d;
			next = null;
		}
	}

	Node head;

	public void push(int new_data)
	{
		Node new_node = new Node(new_data);

		new_node.next = head;

		head = new_node;
	}


	public void deleteNode(int key)
	{
		Node temp = head, prev = null;

		if (temp != null && temp.data == key)
		{
			head = temp.next;
			return;
		}

		while (temp != null && temp.data != key)
		{
			prev = temp;
			temp = temp.next;
		}

		if(temp == null) return;

		prev.next = temp.next;
	}

	public void insertAfter(Node prev_node, int new_data)
	{
		if (prev_node == null)
		{
			System.out.println("The given previous node cannot be null");
			return;
		}

		Node new_node = new Node(new_data);

		new_node.next = prev_node.next;

		prev_node.next = new_node;
	}

	public void append(int new_data)
	{
		Node new_node = new Node(new_data);

		if (head == null)
		{
			head = new Node(new_data);
			return;
		}

		new_node.next = null;

		Node last = head;
		while (last.next != null)
			last = last.next;

		last.next = new_node;
		return;
	}

	public void printList()
	{
		Node n = head;
		while (n != null)
		{
			System.out.print(n.data + " ");
			n = n.next;
		}
	}

	public static void main(String[] args) 
	{
		LinkedList llist = new LinkedList();

		llist.append(6);
		llist.push(7);
		llist.push(1);
		llist.append(4);
		llist.insertAfter(llist.head.next, 8);

		System.out.println("\nCreated Linked list is: ");
		llist.printList();

		llist.deleteNode(1);

		System.out.println("\nLinked List after Delection at position 4:");
		llist.printList();
	}
}