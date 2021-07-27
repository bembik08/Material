package geekbrains.material.ui.photos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.observe
import geekbrains.material.R
import geekbrains.material.model.Mars
import kotlinx.android.synthetic.main.fragment_earth.*
import kotlinx.android.synthetic.main.fragment_earth.but_more
import kotlinx.android.synthetic.main.fragment_mars.*

class MarsFragment : EarthFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mars, container, false)
    }

    override fun init() {
        viewModel.getDataMars().observe(viewLifecycleOwner, { renderData(it) })
        but_more.setOnClickListener {
            val m = viewModel.getNextMarsInfo()
            if (m != null) {
                setImageUrl(m.img_src, this@MarsFragment)
                setInfoText(m)
            }
        }
    }

    private fun setInfoText(m: Mars) {
        info_rover.text = String.format(
            resources.getString(R.string.info_rover),
            m.rover.name, m.rover.status
        )
    }

    override fun getUrl(epicListData: EpicListData.Success<*>) =
        (epicListData.serverResponseData[0] as Mars).img_src

    override fun EpicListData.Success<*>.onDataSuccess() {
        setImageUrl(getUrl(this), this@MarsFragment)
        setInfoText(serverResponseData[0] as Mars)
    }
}
