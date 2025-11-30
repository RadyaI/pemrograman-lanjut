from PIL import Image
import shutil
import os

if not os.path.exists("image.jpeg"):
    print("File tidak ditemukan")
    exit()

gambar = Image.open("image.jpeg")
gambar_ubah = gambar.resize((200, 200))
gambar_ubah.save("resized_image.jpeg")
print("Gambar berhasil disimpan sebagai resized_image.jpeg")

shutil.copy("resized_image.jpeg", "copied_image.jpeg")
print("Salinan gambar berhasil dibuat dengan nama copied_image.jpeg")

if not os.path.exists("gambar"):
    os.makedirs("gambar")

shutil.move("copied_image.jpeg", "gambar/copied_image.jpeg")
print("Salinan gambar dipindahkan ke folder gambar/")

gambar_png = Image.open("gambar/copied_image.jpeg")
gambar_png.save("gambar/image_converted.png")
print("Format gambar diubah menjadi PNG dan disimpan dengan nama image_converted.png")
