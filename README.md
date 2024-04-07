
# E Ticaret Sistemi 

E-Ticaret uygulamasının kurulum ve kullanımı ile ilgili gereksinimler, proje detayları ve adım adım kurulum rehberini içermektedir.

## Gereksinimler

Aşağıdaki araçların kurulu olması gerekmektedir:

- [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

## Proje Detayları

E-Ticaret uygulamamız, kod standartlarına uygun CRUD işlemlerini içerir. Customers, Products, Carts, Cart_Items, Orders, Price_History, Order_Items tablolarını yönetir. Hibernate, MapStruct ve modüler hata yönetimi kullanılarak geliştirilmiştir. Veri güvenliği için DTO sınıfları kullanılmıştır. Servis sınıfları daha modüler ve bağımsız olması için implementation sınıflarına ayrılmıştır. Her müşterinin aynı anda bir sepeti olabileceği için çoğu API isteği müşteri kimliği (customerId) aracılığıyla atılabilir. Controller sınıfları, kurala uygun olarak sadece erişimle görevlendirilmiştir.


### API ISTEKLERI

**Not = Eger Intelij IEDA Ultimate kullaniyorsaniz, request paketi icindeki .http uzantili dosyalar ile  kolay bir sekilde istekler atabilirsiniz.**


***POST*** `/api/v1/customers/register` = Customer olusturur.
```
{
  "email": "selim",
  "password": "1234"
}
```

***POST*** ` /api/v1/products/create ` =  Product olusturur. 
```
{
  "name": "Kiraz",
  "stock": 20,
  "price": 33.00,
  "description": "Kiraz"
}
```

***GET*** `/api/v1/products` = Tum Urunleri getirir listeler.

***DELETE*** `/api/v1/products/{productId}` = Belirli urunu siler.

***PATCH*** `/api/v1/products/{productId} `= Belirli urunun stok ve fiyat bilgisini gunceller.
```
{
  "stock": 50,
  "price": 30.00
}
```

***POST***  `/api/v1/carts/{customerId}/addItem/{productId}` = Sepete yeni bir urun ekler.

***GET*** `/api/v1/carts/{customerId}` = Customerin sepetini listeler.

***PUT*** `/api/v1/carts/{customerId}/updateItem/{productId}` = Customerin sepetindeki urunun adetini gunceller.

***DELETE*** `/api/v1/carts/{customerId}/clearCart` = Sepetteki tum urunleri siler.

***DELETE*** `/api/v1/carts/{customerId}/removeItem/{productId} `= Sepetteki belirli urunu siler.

***POST*** `/api/v1/orders/{customerId}` = Sepetteki urunler ile siparis olusturur.


***GET*** `/api/v1/orders/customer/{customerId}` = Customerin tum siparislerini listeler.


***GET*** `/api/v1/orders/{orderId}` = Siparis numarasina gore siparis listeler.








### **H2 Database ile verileri kontrol edebilmek icin.**

[H2 Database](http://localhost:8080/h2-console/ ) adresi ile database verilerinizi gorebilirsiniz. Assagidaki bilgileri H2 Database Konsoluna giriniz.

```
JDBC URL: jdbc:h2:mem:testDB

User Name:sa

Password:	
```

---
Bu adımı uygulamanıza rağmen projeyi çalıştıramadıysanız benimle iletişim kurabilirsiniz.

	selim.ucarx@gmail.com 
