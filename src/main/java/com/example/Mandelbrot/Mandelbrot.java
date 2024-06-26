package com.example.Mandelbrot;

import java.awt.geom.Rectangle2D;

public class Mandelbrot extends FractalGenerator
{
    /**
     * Константа для количества максимальных итераций.
     */
    public static final int MAX_ITERATIONS = 2500;

    /**
     * Этот метод позволяет генератору фракталов указать, какая часть
     * комплексной плоскости наиболее интересен для фрактала.
     * Ему передается объект прямоугольника, и метод изменяет
     * поля прямоугольника, чтобы показать правильный начальный диапазон для фрактала.
     * Эта реализация устанавливает начальный диапазон в (-2 - 1.5i) - (1 + 1.5i)
     * или x = -3, y = -1,7, width = height = 4.
     */
    public void getInitialRange(Rectangle2D.Double range)
    {
        range.x = -3;
        range.y = -1.7;
        range.width = 4;
        range.height = 4;
    }

    /**
     * Этот метод реализует итерационную функцию для фрактала Мандельброта.
     * Требуется два числа double для действительной и мнимой частей комплекса
     * plane и возвращаетcz количество итераций для соответствующей
     * координаты.
     */
    public int numIterations(double x, double y)
    {
        /** Start with iterations at 0. */
        int iteration = 0;
        /** Initialize zreal and zimaginary. */
        double zreal = 0.0;
        double zimaginary = 0.0;
        double zrealUpdated = 0.0;
        double zimaginaryUpdated = 0.0;

        /**
         * Вычисляем Zn = Zn-1 ^ 2 + c, где значения представляют собой комплексные числа, представленные
         * по zreal и zimaginary, Z0 = 0, а c - особая точка в
         * фрактал, который мы показываем (заданный x и y). Это повторяется
         * до Z ^ 2> 4 (абсолютное значение Z больше 2) или максимум
         * достигнуто количество итераций.
         */
        while (true)
        {
            double a = zreal * zreal + zimaginary * zimaginary;


            if (iteration < MAX_ITERATIONS &&
                    a < 4){
                zrealUpdated = zreal * zreal - zimaginary * zimaginary + x;
                zimaginaryUpdated = 2 * zreal * zimaginary + y;
                zreal = zrealUpdated;
                zimaginary = zimaginaryUpdated;
                iteration += 1;}
            else{
                break;
            }

//            if (iteration > 1 && a == 0.0) {
//                iteration=MAX_ITERATIONS;
//                break;
//            }
        }

        /**
         * Если количество максимальных итераций достигнуто, возвращаем -1, чтобы
         * указать, что точка не вышла за границу.
         */
        if (iteration == MAX_ITERATIONS)
        {
            return -1;
        }

        return iteration;
    }

    /**
     * Реализация toString() в этой реализации фрактала. Возвращает
     * название фрактала: «Мандельброт».
     */
    public String toString() {
        return "Mandelbrot";
    }

}
