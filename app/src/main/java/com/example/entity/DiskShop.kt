package com.example.entity

data object DiskShop : Shop<Disk> {
    override fun sell(): Disk {
        return Disk(7, true, "Веном", "DVD")
    }
}