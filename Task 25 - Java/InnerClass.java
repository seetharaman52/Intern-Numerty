public class InnerClass {
    // Class inside Inner Class
    class Alpha{
        private String name;
        Alpha(String name){
            this.name = name;
        }
        Alpha(){
            this.name = "Anonymous";
        }
        void display(){
            System.out.println("Name: " + name);
        }

        // Class inside Alpha class
        class Beta{
            Beta(){
                System.out.println("Beta class constructor");
            }

            class Gamma{
                Gamma(){
                    System.out.println("Gamma class constructor");
                }
            }
        }
    }
    public static void main(String[] args){
        InnerClass obj = new InnerClass();
        InnerClass.Alpha a = obj.new Alpha("Seetharaman");
        InnerClass.Alpha b = obj.new Alpha();
        InnerClass.Alpha.Beta beta = a.new Beta();
        InnerClass.Alpha.Beta.Gamma gamma = beta.new Gamma();
        a.display();
        b.display();
    }
}
