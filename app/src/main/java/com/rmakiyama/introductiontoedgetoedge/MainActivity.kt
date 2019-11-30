package com.rmakiyama.introductiontoedgetoedge

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import androidx.core.view.updateLayoutParams
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.observe
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.snackbar.Snackbar
import com.rmakiyama.introductiontoedgetoedge.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }
    private val viewModel: MainViewModel by viewModels()
    private val adapter = TextListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.root.layoutFullscreen()
        handlingInsets(binding.root)

        setSupportActionBar(binding.toolbar)
        setupRecyclerView()

        viewModel.texts.observe(this) { adapter.submitList(it) }

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    private fun setupRecyclerView() {
        binding.listText.apply {
            adapter = this@MainActivity.adapter
        }
    }

    private fun View.layoutFullscreen() {
        systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
    }

    private fun handlingInsets(view: View) {
        val fabMargin = resources.getDimensionPixelSize(R.dimen.fab_margin)

        ViewCompat.setOnApplyWindowInsetsListener(view) { _, insets ->
            binding.toolbar.updateLayoutParams<AppBarLayout.LayoutParams> {
                topMargin = insets.systemWindowInsetTop
            }
            binding.fab.updateLayoutParams<CoordinatorLayout.LayoutParams> {
                leftMargin = fabMargin + insets.systemWindowInsetLeft
                rightMargin = fabMargin + insets.systemWindowInsetRight
                bottomMargin = fabMargin + insets.systemWindowInsetBottom
            }
            insets
        }
    }
}
