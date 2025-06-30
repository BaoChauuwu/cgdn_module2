# 📦 QUẢN LÝ SẢN PHẨM ĐƠN GIẢN - FILE NHỊ PHÂN

## 🎯 Mô tả bài toán
Chương trình quản lý sản phẩm **đơn giản** sử dụng **ObjectInputStream/ObjectOutputStream** để đọc/ghi file nhị phân theo mô hình **MVC**.

### Thông tin sản phẩm:
- **Mã sản phẩm** (String)
- **Tên sản phẩm** (String) 
- **Giá** (double)
- **Hãng sản xuất** (String)
- **Mô tả** (String)

## 🚀 Cách chạy chương trình

### 1. Compile:
```bash
javac -cp . ss17/bai1/model/entity/Product.java
javac -cp . ss17/bai1/util/BinaryFileHelper.java
javac -cp . ss17/bai1/model/repository/*.java
javac -cp . ss17/bai1/service/*.java
javac -cp . ss17/bai1/controller/ProductController.java
javac -cp . ss17/bai1/view/ProductView.java
```

### 2. Chạy chương trình:
```bash
java -cp . ss17.bai1.view.ProductView
```

## 🔧 Chức năng (ĐƠN GIẢN)

| STT | Chức năng | Mô tả |
|-----|-----------|-------|
| 1 | **Thêm sản phẩm** | Nhập thông tin sản phẩm mới và lưu vào file |
| 2 | **Hiển thị tất cả** | Xem danh sách toàn bộ sản phẩm |
| 3 | **Xóa sản phẩm** | Xóa sản phẩm khỏi hệ thống |
| 0 | **Thoát** | Thoát chương trình |

## 💾 Đặc điểm kỹ thuật

### 🔹 **File nhị phân:**
- **ObjectOutputStream** để ghi dữ liệu
- **ObjectInputStream** để đọc dữ liệu
- **Serialization** cho Java Object
- Tự động lưu sau mỗi thao tác

### 🔹 **Validation:**
- Mã sản phẩm phải duy nhất
- Giá sản phẩm >= 0
- Các field bắt buộc không được để trống

## 📝 Dữ liệu mẫu có sẵn

| Mã SP | Tên sản phẩm | Giá | Hãng SX | Mô tả |
|-------|--------------|-----|---------|-------|
| SP001 | iPhone 15 Pro | 25,000,000 đ | Apple | Điện thoại thông minh cao cấp |
| SP002 | Samsung Galaxy S24 | 22,000,000 đ | Samsung | Điện thoại Android flagship |
| SP003 | MacBook Air M2 | 28,000,000 đ | Apple | Laptop cao cấp cho công việc |
| SP004 | Dell XPS 13 | 25,000,000 đ | Dell | Laptop business premium |
| SP005 | Sony WH-1000XM5 | 8,000,000 đ | Sony | Tai nghe chống ồn cao cấp |

## ⚙️ Cấu trúc dự án

```
ss17/bai1/
├── model/entity/Product.java         # Entity sản phẩm  
├── model/repository/                 # Repository pattern
├── service/                          # Business logic (đơn giản)
├── controller/ProductController.java # Controller (đơn giản)
├── view/ProductView.java            # Main class (menu đơn giản)
├── util/BinaryFileHelper.java       # File utility
├── data/products.dat                # File nhị phân
└── InitializeData.java              # Tạo dữ liệu mẫu
```

## 🎯 Mục tiêu học tập

- ✅ **ObjectInputStream/ObjectOutputStream**
- ✅ **Serialization** trong Java
- ✅ **MVC Pattern** đơn giản
- ✅ **Exception Handling** cho file I/O
- ✅ **CRUD operations** cơ bản

---
*Phiên bản đơn giản - chỉ thêm & xóa sản phẩm* 