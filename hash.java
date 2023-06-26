import java.util.*;


public class hash {

    static void sortedPrint(Map<String, ArrayList> map) {

        
        Set<String> keySet = map.keySet();

        
        int maxCount = 0;
        int minCount = 1_000_000;
        
        for (var item : map.entrySet()) {
            if (maxCount < item.getValue().size())
                maxCount = item.getValue().size();
            if (minCount > item.getValue().size())
                minCount = item.getValue().size();
            
        }
        
        Stack<String> st = new Stack<>();
        int num = minCount;
        while (num <= maxCount) {
            
            for (var item : map.entrySet()) {
                if (item.getValue().size() == num) {
                    st.push(item.getKey());
                }  
            }
            num += 1;
        }
        
        String name;
        for (int i = 0; i < keySet.size(); i++) {
            name = st.pop();
            for (var item : map.entrySet()) {
                if (name == item.getKey()) {
                    System.out.printf("%8s: ", item.getKey());
                    System.out.println(item.getValue());
                }
            }
        }
        System.out.println();
    }

    

    public static void main(String[] args) {
        
        Map<String, ArrayList> abon = new HashMap<>() {
            {
                put("Иванов", new ArrayList<Integer>() {
                    {
                        add(548963);
                        add(856342);
                        add(544136);
                    }
                });
                put("Капустин", new ArrayList<Integer>() {
                    {
                        add(124512);
                    }
                });
                put("Рыбалкин", new ArrayList<Integer>() {
                    {
                        add(865123);
                        add(314521);

                    }
                });
                put("Ламзин", new ArrayList<Integer>() {
                    {
                        add(899412);
                        add(331145);
                        add(789123);
                        add(951432);
                    }
                });
            }
        };
        System.out.println();
        
        System.out.println("Исходные данные: ");
        sortedPrint(abon);

        
        Scanner scan = new Scanner(System.in, "cp866");
        Boolean getOut = false;
        String st;
        while (!getOut) {
            System.out.println("(1 - добавить абонента, 2 - выйти из программы):");
            st = scan.nextLine();
            String name = "";
            String phString;
            switch (st) {
                case "1": {
                    System.out.println("Введите фамилию :");
                    name = scan.nextLine();
                    if (abon.containsKey(name)) {
                        System.out.println("контак существует");
                        System.out.println();
                        break;
                    } else {
                        System.out.println("Введите номера телефонов через запятую: ");
                        phString = scan.nextLine();
                        String[] arr = phString.split(",");
                        ArrayList<Integer> arrInt = new ArrayList<>();
                        for (String item: arr) {
                            arrInt.add(Integer.parseInt(item.trim())) ;
                        }
                        abon.put(name, arrInt);
                        System.out.println();
                        sortedPrint(abon);
                        break;
                    }
                }
                case "2": {
                    getOut = true;
                    System.out.println();
                    System.out.println("справочник закрыт");
                    System.out.println();
                    break;
                }   
                    
               
            }
        }
    }

}