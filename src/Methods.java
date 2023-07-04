import java.util.*;
import java.util.stream.Collectors;

public class Methods {
    public List<Product> findTypo (List<Product> list){
        return list.stream()
                .filter(ls -> ls.getType()
                .equals("Book"))
                .filter(ls -> ls
                .getPrise() > 250).toList();
    }
    public List<AbstractMap.SimpleEntry<String, Double>> isDiscount(List<Product> list){
        return list.stream()
                .filter(ls -> ls.getType().equals("Book"))
                .filter(Product::getDiscount)
                .map(ls -> new AbstractMap.SimpleEntry<>(ls.getType(), ls.getPrise()*0.9) {})
                .toList();
    }
    public Optional<AbstractMap.SimpleEntry<String, Double>> lowestPrise(List<Product> list){
        Optional<AbstractMap.SimpleEntry<String, Double>> lowestPrise = list.stream()
                .filter(ls -> ls.getType().equals("Book"))
                .filter(Product::getDiscount)
                .map(ls -> new AbstractMap.SimpleEntry<>(ls.getType(), ls.getPrise()*0.9) {})
                .min(Comparator.comparingDouble(AbstractMap.SimpleEntry::getValue));
        if (lowestPrise.isPresent()) {
            return lowestPrise;
        }
        else throw new RuntimeException("Продукт [категорія: Book] не знайдено");
    }

    public List<Product> lastThree(List<Product> list){
        return  list.stream()
                .filter(ls -> ls.getTime() != null)
                .sorted(Comparator.comparing(Product::getTime))
                .limit(3)
                .collect(Collectors.toList());
    }
    public List<Product> dataTypePriceFilter(List<Product> list){
        return  list.stream()
                .filter(ls -> ls.getTime() != null)
                .filter(ls -> ls.getTime().getYear() == 2023)
                .filter(ls -> ls.getType().equals("Book"))
                .filter(ls -> ls.getPrise() < 75)
                .collect(Collectors.toList());
    }
}
