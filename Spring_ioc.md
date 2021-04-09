# Spring程序開發步驟

1. 導入依賴
2. 編寫接口和實現類 （創建bean）
3. 創建Spring核心配置文件（注冊實現類到SpringIOC容器中）



# bean標簽的基本配置

1. id=唯一性標簽，class=全類名
2. scope作用範圍（singleton，prototype）
3. initMethod，destroyMethod
4. bean的三種實例化方法
    - 無參構造方法
    - 靜態工廠方法
    - 實例工廠方法

5. DI依賴注入
    - property 通過getter setter注入
    - constructor-arg 通過構造器注入

6. bean依賴注入的數據類型
    - 普通數據類型
    - 引用數據類型
    - 集合數據類型

7. 引入其他配置文件



# Spring配置數據源 

**（基礎）**

1. 導入依賴（mysql、c3p0..）
2. 創建數據源 ComboPooledDataSource
3. 設置數據源連接參數
4. 獲取Connection
5. connection.close() 歸還到數據源

## 抽取jdbc.properties

## 注冊數據源到Spring容器中

1. 加載jdbc.properties
2. 注冊到IOC容器中