# Respuestas: Ordenamiento y búsqueda

1. **¿Cuál es el caso base en la implementación del algoritmo de ordenamiento QuickSort?**  
   El algoritmo se detiene cuando `izquierda` es mayor o igual que `derecha`, porque ya no hay elementos que ordenar en esa parte.

2. **Escribe un conjunto de datos generado aleatoriamente dentro de tu programa. ¿Cuál es el elemento pivote en la primera ejecución de QuickSort?**  
   Ejemplo: `18, 7, 32, 14, 25, 9, 41, 3, 27, 12, 36, 5, 20, 48, 11, 30, 2, 44, 16, 39`. El pivote inicial es `39`, el último número del arreglo.

3. **¿Qué parte del algoritmo de QuickSort modificarías para que el ordenamiento fuera de mayor a menor?**  
   Cambiaría la comparación `arreglo[i] <= pivote` por `arreglo[i] >= pivote` en la partición.

4. **¿Existe algún otro método recursivo dentro de tu programa? ¿Cuál?**  
   Sí. El método `buscarBinario` también se llama a sí mismo para buscar el número.
