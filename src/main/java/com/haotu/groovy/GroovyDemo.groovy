
class MethodDemo {
    def add(int a, int b) {
        return a + b
    }

    def Display(String name) {
        println("Hello " + name)
    }

    def plus(obj) {
        return "obj is " + obj
    }
}

trait DisplayText {
    void display() {
        println("display text")
    }
}

static void main(String[] args) {
    //Example of a int datatype
    int x = 5;

    //Example of a long datatype
    long y = 100L;

    //Example of a floating point datatype
    float a = 10.56f;

    //Example of a double datatype
    double b = 10.5e40;

    //Example of a BigInteger datatype
    BigInteger bi = 30g;

    //Example of a BigDecimal datatype
    BigDecimal bd = 3.5g;

    println(x);
    println(y);
    println(a);
    println(b);
    println(bi);
    println(bd);

    def range = 5..10
    println(range)
    for (final def num in range) {
        print(num + " ")
    }
    println()
    for (int i in 1..10) {
        print(i + " ")
    }
    println()

    MethodDemo demo = new MethodDemo()
    demo.Display("张三")

    def file = new File("hello.kt")
    println file.text[0..100]
    println('='*80)
    def c = demo + 12
    println(c)
    println(demo + "hello")

    List<String> list = new ArrayList<String>();
    list.add("a");
    list.add("b");
    list.add("c");
    list.forEach { println(it)}

    new DisplayText(){
        void display() {
            println("new implention display text")
        }
    }.display()

    def clos = {param -> println "hello $param"}
    clos("world")
    clos.call("hahaha")


}
