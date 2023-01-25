package quoters;

import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

public class PropertyFileApplicationContext extends GenericApplicationContext {
    public PropertyFileApplicationContext(String fileName) {
        final PropertiesBeanDefinitionReader beanDefinitionReader = new PropertiesBeanDefinitionReader(this);
        int i = beanDefinitionReader.loadBeanDefinitions(fileName); //загружает все бин
        //дифинишны указанные в файле, i - возвращает количество бинов
        System.out.println("Found " + i + " beans"); //вывод бинов
        refresh(); //поосле окончания добавления бинов, должен быть refresh()
    }

    public static void main(String[] args) {
        //передача файла с bean definitions
        final PropertyFileApplicationContext propertyFileApplicationContext
                = new PropertyFileApplicationContext("context.properties");
        //достается класс
        propertyFileApplicationContext.getBean(Quoter.class).sayQuote();
    }
}
