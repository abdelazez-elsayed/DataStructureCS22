import java.lang.Math;
 Public class Polynomial{
    DoubleLinkedList Ac = new DoubleLinkedList();
    DoubleLinkedList Bc = new DoubleLinkedList();
    DoubleLinkedList Cc = new DoubleLinkedList();
    DoubleLinkedList Rc = new DoubleLinkedList();
    DoubleLinkedList Ae = new DoubleLinkedList();
    DoubleLinkedList Be = new DoubleLinkedList();
    DoubleLinkedList Ce = new DoubleLinkedList();
    DoubleLinkedList Re = new DoubleLinkedList();

    //@Override
    public void setPolynomial(char poly, int[][] terms) {

        if (poly == 'A') {
            for (int i = 0; i < terms.length; i++) {
                Ac.add(terms[i][0]);
                Ae.add(terms[i][1]);
            }
        } else if (poly == 'B') {

            for (int i = 0; i < terms.length; i++) {
                Bc.add(terms[i][0]);
                Be.add(terms[i][1]);
            }
        } else if (poly == 'C') {
            for (int i = 0; i < terms.length; i++) {
                Cc.add(terms[i][0]);
                Ce.add(terms[i][1]);
            }
        } else throw new IllegalArgumentException("Unrcognisable poly");

    }
   // @Override
   public String print(char poly){
       String string=new String("");
       if(poly=='A'){

            for (int i=0;i<Ac.size;i++){
                if((int) Ac.get(i)>0)
                    string=string+"+";
                else if((int) Ac.get(i)<0)
                    string=string+"-";
                else
                    continue;
                if((int)Ae.get(i)>1)
                    string=string+Ac.get(i)+"X^"+Ae.get(i);
                else  if((int)Ae.get(i)==1)
                    string=string+Ac.get(i)+"X";
                else
                    string=string+Ac.get(i);
            }

       }
       else if(poly=='B'){
           for (int i=0;i<Bc.size;i++){
               if((int) Bc.get(i)>0)
                   string=string+"+";
               else if((int) Bc.get(i)<0)
                   string=string+"-";
               else
                   continue;
               if((int)Be.get(i)>1)
                   string=string+Bc.get(i)+"X^"+Be.get(i);
               else  if((int)Be.get(i)==1)
                   string=string+Bc.get(i)+"X";
               else
                   string=string+Bc.get(i);
           }
       }
       else if(poly=='C'){
           for (int i=0;i<Cc.size;i++){
               if((int) Cc.get(i)>0)
                   string=string+"+";
               else if((int) Cc.get(i)<0)
                   string=string+"-";
               else
                   continue;
               if((int)Ce.get(i)>1)
                   string=string+Cc.get(i)+"X^"+Ce.get(i);
               else  if((int)Ce.get(i)==1)
                   string=string+Cc.get(i)+"X";
               else
                   string=string+Cc.get(i);
           }
       } else throw new IllegalArgumentException("Wrong poly name");

        return string;
    }
    //@Override
    public void clearPolynomial(char poly) {
        if(poly=='A'){
            Ae.clear();
            Ac.clear();
        }
        else if(poly=='B'){
            Be.clear();
            Bc.clear();
        }
        else if(poly=='C'){
            Ce.clear();
            Cc.clear();
        }else throw new IllegalArgumentException("Wrong Entry");
    }

    // @Override
     public float evaluatePolynomial(char poly, float value) {
         float f=0;
         if(poly=='A'){
             for(int i=0;i<Ac.size;i++){
                 f += (float) Ac.get(i)*Math.pow(value,(double)Ae.get(i));
             }
         }else if(poly=='B'){
             for(int i=0;i<Bc.size;i++){
                 f += (float) Bc.get(i)*Math.pow(value,(double)Be.get(i));
             }
         }else if(poly=='C'){
             for(int i=0;i<Cc.size;i++){
                 f += (float) Cc.get(i)*Math.pow(value,(double)Ce.get(i));
             }
         }else throw new IllegalArgumentException("Wrong index");
         return f;

     }
 }
