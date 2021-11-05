class Test {
    public static void main(String[] args) {
double dmoney = 42; float fmoney = 42f;

for(long n = 0; n < 1000000000; n++){
    dmoney += 0.1;
    fmoney += 0.1f;
}

System.out.format("Double: %.9f%n",dmoney);
System.out.format("Float:  %.9f%n",fmoney);
    }
}