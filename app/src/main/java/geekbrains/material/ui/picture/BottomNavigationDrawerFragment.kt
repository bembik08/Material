package geekbrains.material.ui.picture

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import geekbrains.material.R
import geekbrains.material.ui.photos.PhotosActivity
import geekbrains.material.ui.settings.SettingsFragment
import geekbrains.material.ui.todolist.ToDoListActivity
import kotlinx.android.synthetic.main.bottom_navigation_layout.*

class BottomNavigationDrawerFragment : BottomSheetDialogFragment() {
    private val TAG_SETTINGS = "TAG_SETTINGS"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_navigation_layout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        navigation_view.setNavigationItemSelectedListener { menuItem ->
            val frSettings = activity?.supportFragmentManager?.findFragmentByTag(TAG_SETTINGS)
            when (menuItem.itemId) {
                R.id.navigation_mrfoto -> {
                    startActivity(Intent(requireActivity(), PhotosActivity::class.java))
                }
                R.id.navigation_settings ->
                    if (frSettings == null)
                        activity?.supportFragmentManager?.beginTransaction()
                            ?.replace(R.id.container, SettingsFragment.newInstance(), TAG_SETTINGS)
                            ?.addToBackStack(null)?.commit()
                    else
                        activity?.supportFragmentManager?.beginTransaction()
                            ?.replace(R.id.container, frSettings)
                R.id.navigation_todolist -> {
                    requireActivity().let {
                        startActivity(
                            Intent(
                                it,
                                ToDoListActivity::class.java
                            )
                        )
                    }
                }
            }
            dismiss()
            true
        }
    }
}
