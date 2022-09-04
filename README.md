
#Lazy Loading vs Eager Loading

## Lazy Loading

Lazy Loading, sayfada yer alan bir ögenin ihtiyaç duyulmadığı takdirde çağrılmaması prensibi ile çalışır yani bir nesne örneğinin gerçekten ihtiyaç duyulacağı ana kadar alınmaması ve bekletilmesi amacıyla kullanılır. Bu yöntemde veriler sorguya bağlı olarak çekilir ve veri setinin içindeki tüm dataları yüklemek yerine kullanılacağı an tekrar sorgu atar ve veriyi çeker.
Örnek
Örneğin, aşağıda verilen sorguyu çalıştırdığımızda, UserDetails tablosu Kullanıcı tablosu ile birlikte yüklenmeyecektir.
```
User usr = dbContext.Users.FirstOrDefault(a => a.UserId == userId);
```
Yalnızca, aşağıda gösterildiği gibi, açıkça aradığınızda yüklenir.
UserDeatils ud = usr.UserDetails; // UserDetails are loaded here
Buda her yeni yükleme için veritabanına bir sorgu atılması demektir.

## Eager Loading

Lazy Loading’in tam tersi yönde çalışır. Kullanacağımız nesneleri, nesnenin ihtiyaç anından çok önce yaratır ve bekletir. Eager loading Linq sorgusu çalıştırıldığında verilerin tamamını yükler ve hafızaya alır.
Örnek
Örneğin, bir Kullanıcı tablonuz ve bir KullanıcıDetaylar tablonuz (Kullanıcı tablosuyla ilişkili varlık), o zaman aşağıda verilen kodu yazacaksınız. Burada, kullanıcıyı kullanıcı detayları ile birlikte kullanıcı kimliğine eşit bir ID ile yüklüyoruz.
```
User usr = dbContext.Users
                    .Include(a => a.UserDetails)
                    .FirstOrDefault(a => a.UserId == userId);
                    
  ```
Eğer birden fazla alt öğe seviyemiz varsa, aşağıdaki sorguyu kullanarak yükleyebilirsiniz.

```
User usr = dbContext.Users
.Include(a => a.UserDetails.Select(ud => ud.Address))
.FirstOrDefault(a => a.UserId == userId);
```
Bu, ilişkili varlıkları sorgunun bir parçası olarak döndüren ve bir kerede büyük miktarda veri yükleyen yöntem bize zaman ve hız kazandırıyor.
