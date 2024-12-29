package hello.itemservice.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {
    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    public void clear(){
        itemRepository.clearStore();
    }

    @Test
    @DisplayName("저장 테스트")
    public void save(){
        Item item1 = new Item("scott",1000, 1);
        Item savedItem = itemRepository.save(item1);

        Assertions.assertThat(item1).isEqualTo(savedItem);

    }

    @Test
    @DisplayName("찾기")
    void find(){
        Item item1 = new Item("scott",1000, 1);
        Item savedItem = itemRepository.save(item1);

        Item item2 = new Item("scott-reverse",1000, 1);
        Item savedItem2 = itemRepository.save(item2);

        List<Item> allItems = itemRepository.findAll();

        Assertions.assertThat(allItems.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("업데이트")
    void updateItem(){
        Item item1 = new Item("scott",1000, 1);
        Item savedItem = itemRepository.save(item1);

        Long updateItemId = savedItem.getId();

        Item updateItem = new Item("scott-userd", 20000, 1);
        itemRepository.update(updateItemId, updateItem);

        //
        Item updatedItem = itemRepository.findById(updateItemId);
        Assertions.assertThat(updatedItem.getItemName()).isEqualTo(updateItem.getItemName());


    }



}