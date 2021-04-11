# SpringMVC 

1. 前端控制器
2. 配置Servlet
3. 編寫Controller
4. 將Controller注冊到容器中
5. 配置spring-mvc.xml，配置組件掃描



## 開發步驟

1. 導入SpringMVC

2. 配置SpringMVC核心控制器DispatcherServlet

3. 創建Controller類和視圖頁面

    ```java
    public class UserController {
        public String save() {
            System.out.println("userController save() running");
    
    
            // return 要跳轉的視圖
            return "success.jsp";
        }
    }
    ```

4. 使用注解配置Controller類中業務方法的映射地阯

5. 配置SpringMVC核心文件spring-mvc.xml

    ```xml
      <!--配置spring mvc前端控制器-->
      <servlet>
        <servlet-name>DispatcherServlet</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
          <param-name>contextConfigLocation</param-name>
          <param-value>classpath:spring-mvc.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
      </servlet>
      <servlet-mapping>
        <servlet-name>DispatcherServlet</servlet-name>
        <url-pattern>/</url-pattern>
      </servlet-mapping>
    ```

    

## 内部資源視圖解析器

```xml
    <!--配置内部資源解析器-->
    <bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/jsp/"/>
        <property name="suffix" value=".jsp"/>
    </bean>
```



## SpringMVC的數據響應

1. 頁面跳轉
    - 返回字符串
    - 返回ModelAndView

2. 回寫數據
    - 直接返回字符串
    - 返回對象或集合



## \<mvc:annotation-driven>

1.自动注册映射处理器和适配器
这是该注解的主要功能，添加< mvc:annotation-driven/>注解后，容器中会<自动注册HandlerMapping与HandlerAdapter 两个bean。省去手动注册HandlerMapping和HandlerAdapter的步骤。

当配置了< mvc:annotation-driven/>后，Spring就知道了我们启用注解驱动。然后Spring通过< context:component-scan/>标签的配置，会自动为我们将扫描到的@Component，@Controller，@Service，@Repository等注解标记的组件注册到工厂中，来处理我们的请求
...一大堆作用



## SpringMVC 獲得請求數據

> name=value&name=value...

- 基本類型參數	（Controller方法中的參數名稱需和請求參數的name一致，參數值能夠自動映射）（若不一致，使用@requestParam顯式綁定）
- POJO類型參數 （Controller方法中POJO參數的屬性名與請求參數的name一致，參數值能夠自動映射）
- 數組類型參數（Controller方法中數組名稱與請求參數的name一致，參數值能夠自動映射）



## 獲取集合類型參數 

### - VO對象

封裝List集合，獲取請求數據

### -ajax 

指定ContentType為JSON形式	，在方法參數位置加上@RequestBody可以直接接受數據



## \<mvc:resources mapping="" location="">

開放資源的訪問，JS/img/...



## 統一編碼

CharacterEncodingFilter



## 參數綁定注解 @RequestParam

- value 請求參數名稱
- required 默認爲true（若不提交則報錯）
- defaultValue 當沒有指定請求參數時，則使用指定默認值



## Restful風格請求參數

url+請求方式

> /user/1 GET 得到id=1 的 user
>
> /user/1 DELETE 刪除id=1 的user
>
> /user/1 PUT 得到id=1的uesr
>
> /user POST 新增user

/user/{id}



## 自定義類型轉換器

1. 定義轉換器類實現Converter接口
2. 在配置文件中聲明轉換器
3. 在\<annotation-driven>中引用轉換器



1. ```java
    DateConverter implements Converter<String, Date>
    ```

2. ```xml
    <bean id="conversionService" class="org.springframework.context.support.ConversionServiceFactoryBean">
        <property name="converters">
            <list>
                <bean class="com.jackson.converter.DateConverter"/>
            </list>
        </property>
    </bean>
    ```

3. ```xml
    <mvc:annotation-driven conversion-service="conversionService"/>
    ```



## 獲取請求頭

@RequestHeader（value=請求頭的名稱，required=是否必須携帶）

```java
public void reqHeader(@RequestHeader(value = "Host", required = true) String host)
```



### @CookieValue

- value 指定cookie的名稱

- required 是否必須携帶



## 文件上傳

文件上傳客戶端三要素

- 表單項type=file
- 提交方式post
- enctype="multipart/form-data"

1. 導入依賴
2. 配置文件上傳解析器
3. 編寫文件上傳代碼



## 攔截器 interceptor

1. 創建攔截器類實現HandlerInterceptor
    - preHandle		目標方法執行之前執行（判斷是否放行，返回true放行）
    - postHandle       目標方法執行之后，視圖返回之前執行
    - afterCompletion   整個流程都執行完畢后執行
2. 配置攔截器

```xml
    <!--配置攔截器 interceptor-->
    <mvc:interceptors>
        <mvc:interceptor>
            <mvc:mapping path="/**"/> <!--對哪些資源執行攔截操作-->
            <mvc:exclude-mapping path="/user/login"/> <!--配置排除哪些資源攔截-->
            <bean class="com.jackson.interceptor.MyInterceptor"/>
        </mvc:interceptor>
    </mvc:interceptors>
```



## 異常處理

1. 預期異常
2. 運行時異常

dao ，service，controller通過throws Exception向上抛出，最後由SpringMVC前端控制器交由異常處理器進行異常處理（HandlerExceptionResolver）

1. 使用SimpleMappingExceptionResolver

    ```XML
        <!--配置簡單映射異常處理器-->
        <bean class="org.springframework.web.servlet.handler.SimpleMappingExceptionResolver">
            <property name="defaultErrorView" value="error"/>
            <property name="exceptionMappings">
                <map>
                    <entry key="java.lang.ClassCastException" value="cast_exception"/>
                    <entry key="com.jackson.exception.MyException" value="custom_exception"/>
                </map>
            </property>
        </bean>
    ```

    

2. 自定义异常处理

    1. 创建异常处理器类实现HandlerExceptionResolver
    2. 配置异常处理器