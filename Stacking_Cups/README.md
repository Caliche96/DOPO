# Stacking Cups — Registro de Cambios

> **Autores:** Carlos Rojas  
> **Versión:** 1.0 — 2026-1  
> **Última actualización:** 2026-03-26

---

## 📁 Estructura del Proyecto

```
Stacking_Cups/
└── src/
    ├── StackingItem.java   → Clase abstracta base (sin modificaciones)
    ├── Cup.java            → Representa una taza apilable
    ├── Lid.java            → Representa una tapa apilable
    ├── Tower.java          → Lógica principal del simulador
    └── Canvas.java         → Motor gráfico (sin modificaciones relevantes)
```

---

## 🗂️ Cambios por Archivo

### `StackingItem.java` — Sin cambios
Clase abstracta base. Define los campos `number`, `height`, `color` y el método abstracto `getType()`.  
**No fue modificada.**

---

### `Cup.java`

| Cambio | Detalle |
|--------|---------|
| Actualización de Javadoc | Descripción en inglés con autores y versión |
| Nuevos campos privados | `private int height`, `private Rectangle shape`, `private boolean visible` |
| Nuevos métodos | `getShape()`, `isVisible()`, `setVisible(boolean)` |

**Estado actual de los métodos:**
- `Cup(int number, String color)` — constructor, altura = `2*number - 1` ✅
- `getType()` — retorna `"Cup"` ✅
- `getShape()` — retorna el `Rectangle` visual (pendiente de inicializar) ⚠️
- `isVisible()` / `setVisible()` — control de visibilidad gráfica ⚠️

> ⚠️ `shape` aún no se inicializa en el constructor. Pendiente conectar con `Canvas`.

---

### `Lid.java`

| Cambio | Detalle |
|--------|---------|
| Nuevos campos privados | `private int height`, `private Rectangle shape`, `private boolean visible` |
| Nuevos métodos | `getShape()`, `isVisible()`, `setVisible(boolean)` |

**Estado actual de los métodos:**
- `Lid(int number, String color)` — constructor, altura fija = `1` ✅
- `getType()` — retorna `"Lid"` ✅
- `getShape()` — retorna el `Rectangle` visual (pendiente de inicializar) ⚠️
- `isVisible()` / `setVisible()` — control de visibilidad gráfica ⚠️

> ⚠️ `shape` aún no se inicializa en el constructor. Pendiente conectar con `Canvas`.

---

### `Tower.java` — Archivo principal

#### Corrección de bug
- **Variable local `items` renombrada a `grid`** en `stackingItems()` para evitar *shadowing* del campo `private ArrayList<StackingItem> items`. Este conflicto causaba el error de compilación:  
  `"Syntax error, insert VariableDeclarators to complete LocalVariableDeclaration"`

#### Métodos implementados / modificados

| Método | Estado | Descripción |
|--------|--------|-------------|
| `pushCup(int i)` | ✅ Completo | Agrega una taza si no existe y cabe en la torre |
| `popCup()` | ✅ Completo | Elimina la taza de la cima (falla si la cima no es taza) |
| `removeCup(int i)` | ✅ Completo | Elimina taza específica; falla si tiene tapa encima |
| `pushLid(int i)` | ✅ Completo | Agrega una tapa si no existe y cabe en la torre |
| `popLid()` | ✅ Completo | Elimina la tapa de la cima (falla si la cima no es tapa) |
| `removeLid(int i)` | ✅ Completo | Elimina tapa específica por número |
| `orderTower()` | ✅ Completo | Ordena de mayor a menor (base → cima), respetando `maxHeight` |
| `reverseTower()` | ✅ Completo | Ordena de menor a mayor (base → cima), respetando `maxHeight` |
| `height()` | ✅ Completo | Suma las alturas de todos los elementos apilados |
| `lidedCups()` | ✅ Completo | Retorna `int[]` con los números de tazas que tienen tapa inmediatamente encima, ordenados de menor a mayor |
| `stackingItems()` | ⚠️ Parcial | Retorna `String[][]` — estructura definida, pendiente de implementar con datos reales de `items` |
| `makeVisible()` | ⚠️ Pendiente | Actualmente solo imprime en consola |
| `makeInvisible()` | ⚠️ Pendiente | Actualmente solo imprime en consola (renombrado de `makesInvisible`) |
| `exit()` | ✅ Completo | Llama a `makeInvisible()` |
| `ok()` | ✅ Intocable | Retorna estado de la última operación — **no modificar** |

#### Métodos auxiliares privados (implementados)

| Método | Descripción |
|--------|-------------|
| `cupExists(int i)` | Verifica si existe una taza con número `i` |
| `lidExists(int i)` | Verifica si existe una tapa con número `i` |
| `findItem(String type, int number)` | Busca un elemento por tipo y número, retorna índice o `-1` |
| `assignColor(int number)` | Asigna color persistente por número usando `COLORS[]` y `colorMap` |
| `sortedByNumber(boolean reversed)` | Ordena todos los items por número; si `reversed=true`, orden ascendente |
| `trimToHeight(ArrayList<StackingItem>)` | Trunca la lista para no exceder `maxHeight` |

#### Regla importante de implementación
> 🚫 **No usar `instanceof`** para distinguir entre `Cup` y `Lid`.  
> ✅ Usar siempre `item.getType().equals("Cup")` o `item.getType().equals("Lid")`.

---

### `Canvas.java` — Sin cambios relevantes
Motor gráfico heredado (BlueJ). Maneja el renderizado 2D con `Rectangle` y colores.  
Se usa como singleton a través de `Canvas.getCanvas()`.

---

## 🔜 Pendiente / Próximos pasos

- [ ] **Implementar `stackingItems()`** correctamente: debe retornar `{{"cup"/"lid", "<numero>"}}` iterando sobre `this.items`
- [ ] **Conectar `Cup` y `Lid` con `Canvas`**: inicializar `shape` en el constructor y dibujar con `Canvas.getCanvas().draw(...)`
- [ ] **Implementar `makeVisible()` / `makeInvisible()`** en `Tower`: iterar sobre `items` y llamar `setVisible()` en cada uno
- [ ] **Implementar la parte gráfica** completa del simulador

---

## 📌 Convenciones del proyecto

- La torre almacena elementos en `ArrayList<StackingItem> items` de **base (índice 0) a cima (último índice)**
- Cada taza número `i` tiene altura `2i - 1` cm
- Cada tapa tiene altura fija de `1` cm
- Los colores se asignan por número y son persistentes durante la sesión (`colorMap`)
- `ok` se actualiza en cada operación para indicar si fue exitosa
