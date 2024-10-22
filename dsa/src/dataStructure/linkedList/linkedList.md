# LinkedList ( 鏈結串列 )

### 鏈結串列是一種由節點（Node）組成，透過指標連結各節點的線性資料結構。

#### 特點：
- 每個節點包含資料（ data ）以及指向下一個節點的指標（ next ）。
- 不需要連續的記憶體空間，可動態調整大小。
- 常用操作：insert ( 插入 )、delete ( 刪除 )、search ( 搜尋 )、traverse ( 遍歷 )。
- 增刪之時間複雜度：
    - 已知位置時的插入刪除為 O(1)
    - 搜尋特定元素為 O(n)
    - 存取特定位置元素為 O(n)

#### 額外說明：
- 常見變體包括：單向、雙向、環狀鏈結串列。
- 相較於陣列，優點是可動態調整大小且插入刪除較快；缺點是無法隨機存取且需額外記憶體存放指標。
- 可用來實作其他資料結構，如堆疊、佇列等。
- 適合用於需要頻繁插入刪除操作的場合。