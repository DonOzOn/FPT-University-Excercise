/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testlist;

/**
 *
 * @author Don OzOn
 */
public class mylist {

    Node head, tail;
    private Object xname;

    mylist() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);

    }

    void clear() {
        head = tail = null;
    }
  void addMany(String [] a, int [] b)
     {int n,i; n=a.length;
       for(i=0;i<n;i++) addlast(new person(a[i],b[i]));
     }
    void addlast(person x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }

    void addfirst(person x) {
        head = new Node(x, head);
        if (tail == null) {
            tail = head;
        }
    }

    Node search(String x) {
        Node p = head;
        while (p != null) {
            if (p.infor.name.equals(xname)) {
                return (p);
            }
            p = p.next;
        }
        return null;
    }
     Node searchByName(String xName)
     {Node p=head;
       while(p!=null)
        {if(p.infor.name.equals(xName)) return(p);
          p=p.next;
        }
       return(null);
     }
   
    void visit(Node p) {
        if (p == null) {
            return;
        }
        System.out.println(p.infor + " ");
    }

    void traverse() {
        Node p = head;
        while (p != null) {
            visit(p);
            p = p.next;
        }
    }

    void addlastmany(String[] a, int[] b) {
        int n, i;
        n = a.length;
        for (i = 0; i < n; i++) {
            addlast(new person(a[i], b[i]));
        }
    }
       // (4)
   void insertAfter(Node q, person x)
     {
         if(q==null) return;
         Node q1=q.next;
         Node p=new Node(x,q1);
         q.next=p;
         if(tail==q) tail=p;
            
         
     }


   // (5)
   void insertBefore(Node q, person x)
     {
         if(q==null)return;
         if(q==head){
             addfirst(x);
         return;
         }
         Node p=head;
         while(p!=null&&p.next!=q)p=p.next;
         if(p==null)return;
         insertAfter(p, x);
     }

   // (6)
   void dele(Node q)
     {
         if(q==null)return;
         if(q==head){
             head=head.next;
             
             if(head==null)tail= null;
         }
         //find the node before q
        Node p=head;
        while(p!=null&&p.next!=q){
            p=p.next;
            if (p==null)return;
            
        }
     }

   // (7)
   void dele(String xName)
     {
         
     }

   // (8)
   void dele(int xAge)
     {
         
     }

   // (9)
   void deleAll(int xAge)
     {
     }

   // (10)
   Node pos(int k)
     {
         int i=0;
         Node p=head;
         while(p!=null){
             if(i==k)return p;
             i++;
             p=p.next;
         }
         return null;
         
     }

   // (11)
   void delePos(int k)
     {
         Node q=pos (k);
         dele(q);
     }

   // (12)
   void sortByName()
     {Node pi,pj;
     person x;
     pi=head;
     while(pi!=null)
     {
         pj=pi.next;
         while(pj!=null){
             if(pj.infor.name.compareTo(pi.infor.name)<0){
                 
             }
         }
     }
         
         
         
     }

   // (13)
   void sortByAge()
     {
     }


   // (14)
   int size()
     {
         int i=0;
         
         return(0);
     }

   // (15)
   person [] toArray()
     {return(null);
     }

   // (16)
   void reverse()
     {
         mylist t=new mylist();
         Node p=head;
         while(p!=null){
             t.addfirst(new person(p.infor.name,p.infor.age));
             p=p.next;
             
         }
         head=t.head;
         tail=t.tail;
     }

  // (17) 
  Node findMaxAge()
     {
         Node p,q;
         p=q=head;
         int xAge=p.infor.age;
         while(p!=null){
             if(p.infor.age>xAge){
                 q=p;
                 xAge =p.infor.age;
             }
             p=p.next;
         }return q;
  
     }

  // (18) 
  Node findMinAge()
     { Node p,q;
         p=q=head;
         int xAge=p.infor.age;
         while(p!=null){
             if(p.infor.age<xAge){
                 q=p;
                 xAge =p.infor.age;
             }
             p=p.next;
         }return q;
     }

  // (19) 
  void setData(Node p, person x)
     {
         p.infor =x;
     }

  // (20) 
  void sortByAge(int  k, int h)
     {
         if(k >= h)return;
         
         if(k<0)k=0;
         int n=size();
         if(h>n-1)h=n-1;
         Node u,v;
         
         
     }

 }

