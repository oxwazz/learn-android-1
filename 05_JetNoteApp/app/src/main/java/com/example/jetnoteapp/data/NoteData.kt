package com.example.jetnoteapp.data

import com.example.jetnoteapp.model.Note

class NotesDateSource {
    fun loadNotes(): List<Note> {
        return listOf(
            Note(
                title = "Makan Pagi",
                description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry."
            ),
            Note(
                title = "Siram Tanaman",
                description = "make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting."
            ),
            Note(
                title = "Masak Pagi",
                description = "Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc."
            ),
            Note(
                title = "Sholat di Masjid",
                description = "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested."
            ),
            Note(
                title = "Minum Air Putih 1 liter",
                description = "Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia."
            ),
            Note(
                title = "Lari Pagi",
                description = "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots."
            ),
            Note(
                title = "Ngaji",
                description = "combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable."
            ),
            Note(
                title = "Hafalan Al Qur'an",
                description = "Various versions have evolved over the years, sometimes by accident, sometimes on purpose."
            ),
            Note(
                title = "Muroja'ah Al Qur'an",
                description = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered ."
            ),
            Note(
                title = "Cuci Motor",
                description = "web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum'."
            ),
            Note(
                title = "Cuci Baju",
                description = "Ipsum is that it has a more-or-less normal distribution of letters, as opposed to."
            ),
            Note(
                title = "Bersih-bersih Rumah",
                description = "more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
            ),
        )
    }
}