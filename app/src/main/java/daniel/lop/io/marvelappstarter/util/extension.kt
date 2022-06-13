package daniel.lop.io.marvelappstarter.util

import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(
        requireContext(),
        message,
        duration
    ).show()
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.INVISIBLE
}