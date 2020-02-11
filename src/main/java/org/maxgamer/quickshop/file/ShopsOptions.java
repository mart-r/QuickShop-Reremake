/*
 * MIT License
 *
 * Copyright © 2020 Bukkit Commons Studio
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package org.maxgamer.quickshop.file;

import io.github.portlek.configs.util.MapEntry;
import io.github.portlek.database.SQL;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.maxgamer.quickshop.Shop;

import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@RequiredArgsConstructor
public final class ShopsOptions {

    @NotNull
    private final SQL sql;

    @NotNull
    public Shops value() {
        final Map<UUID, Shop> shops = new ConcurrentHashMap<>();

        // TODO: 11.02.2020 Load the shops from the sql.
        sql.createTable(
            "shops",
            Arrays.asList(
                MapEntry.of("id", "NOT NULL AUTO_INCREMENT"),
                MapEntry.of("uuid", "NOT NULL"),
                // TODO: 11.02.2020 Manager, ShopTypes, Stacks.
                MapEntry.of("UNIQUE", "(`id`, `uuid`)")
            )
        );

        return new Shops(shops);
    }

}