package logic;

public enum Operator {

     AND {
             public String toString() {
                     return "&";
             }
     },

     OR {
             public String toString() {
                     return "|";
             }
     },

     IF {
             public String toString() {
                     return "->";
             }
     },

     NEG {
         public String toString() {
                 return "!";
         }
 }

 }