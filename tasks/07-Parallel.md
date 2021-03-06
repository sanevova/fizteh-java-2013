## Параллельный доступ

Доступ из нескольких потоков. Псевдо-транзакционный механизм.

### Псевдо-транзакционные изменения

Хранилище между коммитами аккумулирует отдельный список изменений для каждого потока.
Для каждого потока получается собственный дифф, в котором записаны ключи и значения, которые нужно положить и удалить.
```rollback``` должен откатывать дифф только для текущего потока.

### Очередь коммитов

Функция ```commit``` должна гарантированно работать при одновременном вызове из нескольких потоков.
Одновременные вызовы ```commit``` должны образовывать "честную" очередь.
Как только начинается выполнение очередного коммита, коммит просто накатывает свои изменения, без проверки каких-либо условий.
По завершении коммита все потоки должны знать о последних прочитанных данных.
Работа с диском, как и в предыдущей работе, происходит только во время коммита.

### TableProvider и TableProviderFactory

TableProvider должен гарантировать целостность состояния при работе с несколькими потоками.
Например, если в одном потоке был вызван ```createTable(table1)```, то вызов ```createTable(table1)``` из другого потока должен вернуть ```null```, а ```getTable(table1)``` - ту самую свежесозданную таблицу.

Для TableProviderFactory синхронизация не требуется.


