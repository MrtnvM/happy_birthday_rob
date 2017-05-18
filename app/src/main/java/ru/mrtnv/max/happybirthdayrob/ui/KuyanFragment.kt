package ru.mrtnv.max.happybirthdayrob.ui

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import kotlinx.android.synthetic.main.fragment_kuyan.*
import ru.mrtnv.max.happybirthdayrob.R
import android.R.attr.pivotY
import android.R.attr.pivotX
import android.animation.ObjectAnimator
import android.view.animation.*


class KuyanFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_kuyan, container, false)
    }

    override fun onStart() {
        super.onStart()

        val startDelay = 2
        val rotationTime: Long = 1300

        val animSet = AnimationSet(false)

        val rotate = RotateAnimation(0f, -15f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        rotate.duration = 1000
        rotate.interpolator = AccelerateInterpolator() as Interpolator?
        rotate.fillAfter = true


        val r = ObjectAnimator.ofFloat(rob, View.ROTATION, 0f, 15f).apply {
            duration = 800
            interpolator = AccelerateInterpolator()
        }

        val t = ObjectAnimator.ofFloat(glasses, View.Y, -100f, rob.height/2f).apply {
            duration = 800
            interpolator = AccelerateInterpolator()
            setStartDelay(700)
        }


//                .setDuration(800)
//                .setInterpolator(AccelerateInterpolator()))
//        rob.startAnimation(rotate)

//        val translate = TranslateAnimation(glasses.width / 2f, glasses.width / 2f, -100f, rob.height/2f);
////        val glassesAnim = glasses.animate().y(rob.height/2f)
////        glassesAnim.startDelay = rotationTime
////        glassesAnim.duration = 1000
////        glassesAnim.start()
//
//        translate.duration = 850
//        translate.startOffset = 1000
//        translate.interpolator = AccelerateInterpolator()
//        translate.fillAfter = true
//        translate.

//        glasses.startAnimation(translate)


//        val glassesAnim = glasses.animate().y(100f + rob.height/2)
//        glassesAnim.startDelay = rotationTime
//        glassesAnim.duration = 1000
//        glassesAnim.start()
//
//        YoYo.with(Techniques.Tada)
//                .duration(700)
//                .repeat(2)
//                .onEnd( {
//
//                 })
//                .playOn(rob)
    }



    companion object {
        fun newInstance(): KuyanFragment {
            val fragment = KuyanFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}
