# Server trả về ResponseEntity.ok("Hello")

- Khi trả về Client thì response là string

```js
//Nếu không có await thì sẽ trả về một Promise Object, sau đó gọi json() thì ra
// lỗi do response là string
let result = (await response.text()).toString();
```
